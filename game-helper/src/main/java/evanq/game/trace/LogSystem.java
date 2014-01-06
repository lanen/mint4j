package evanq.game.trace;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import evanq.game.helper.New;
import evanq.game.utils.IOUtils;


/**
 * The trace mechanism is the logging facility of this database. There is
 * usually one trace system per database. It is called 'trace' because the term
 * 'log' is already used in the database domain and means 'transaction log'. It
 * is possible to write after close was called, but that means for each write
 * the file will be opened and closed again (which is slower).
 */
public class LogSystem implements LogWriter {

    /**
     * The default level for system out trace messages.
     */
    public static final int DEFAULT_TRACE_LEVEL_SYSTEM_OUT = LogLevel.OFF;

    /**
     * The default level for file trace messages.
     */
    public static final int DEFAULT_TRACE_LEVEL_FILE = LogLevel.ERROR;

    /**
     * The default maximum trace file size. It is currently 64 MB. Additionally,
     * there could be a .old file of the same size.
     */
    private static final int DEFAULT_MAX_FILE_SIZE = 64 * 1024 * 1024;
    
    /**
     * 限制每次写入的数据大小
     */
    private static final int CHECK_SIZE_EACH_WRITES = 128;
    
    /**
     * 输出到System.out的级别
     */
    private int levelSystemOut = DEFAULT_TRACE_LEVEL_SYSTEM_OUT;
    
    /**
     * 输出到文件的级别
     */
    private int logLevel = DEFAULT_TRACE_LEVEL_FILE;
    private int levelMax;

    private int maxFileSize = DEFAULT_MAX_FILE_SIZE;
    
    private String fileName;
    
    private HashMap<String, Trace> traces;
    private SimpleDateFormat dateFormat;
    
    //用于将日志输出到指定的文件
    private Writer fileWriter;
    private PrintWriter printWriter;
    
    private int checkSize;
    private boolean closed;
    private boolean writingErrorLogged;
    
    private LogWriter writer = this;
    private PrintStream sysOut = System.out;
    
    /**
     * 日志所属模块
     */
    private String module;
    private boolean delegateSlf4j;
    private boolean appendClassName= false;
    /**
     * create a  new module log system
     * @param module
     */
    public LogSystem(String module) {
    	if(null == module){
    		throw new NullPointerException("module");
    	}
        setName(module);
        updateLogLevel();
        this.delegateSlf4j = false;
    }
    
    
    /**
     *
     * @param module
     * @param logFileName
     */
    public LogSystem(String module,String logFileName){
    	this(module);
    	
    	if(null == logFileName){
    		throw new NullPointerException("logFileName");
    	}
    	
    	//日志文件输出
    	this.fileName = logFileName;
    }

    public LogSystem(String module,boolean delegateSlf4j){
    	this(module);
    	this.delegateSlf4j = delegateSlf4j;
    }
    
    public void setLogLevel(int level){    	
    	this.logLevel = level;
    	this.levelSystemOut = level;
    	updateLogLevel();
    }
    
    private void updateLogLevel() {
        levelMax = Math.max(levelSystemOut, logLevel);
    }

    /**
     * Set the print stream to use instead of System.out.
     *
     * @param out the new print stream
     */
    public void setSysOut(PrintStream out) {
        this.sysOut = out;
    }

    /**
     * Write the exception to the driver manager log writer if configured.
     *
     * @param e the exception
     */
    public static void traceThrowable(Throwable e) {
    	//TODO 将异常重定向到制定的日志writer
    	e.printStackTrace();
//        PrintWriter writer = DriverManager.getLogWriter();
//        if (writer != null) {
//            e.printStackTrace(writer);
//        }
    }

    /**
     * Get or create a trace object for this module. Trace modules with names
     * such as "JDBC[1]" are not cached (modules where the name ends with "]").
     * All others are cached.
     *
     * @param module the module name
     * @return the trace object
     */
    public synchronized Trace getTrace(String module) {
        if (module.endsWith("]")) {
            return new Trace(writer, module);
        }
        if (traces == null) {
            traces = New.hashMap(16);
        }
        Trace t = traces.get(module);
        if (t == null) {
            t = new Trace(writer, module);
            traces.put(module, t);
        }
        return t;
    }
    
    public synchronized Trace getTrace(Class<?> clazz){
    	if(delegateSlf4j){
    		LogWriterAdapter adaptor = new LogWriterAdapter(clazz);
    		return new Trace(adaptor, module);
    	}
    	
    	if (appendClassName) {
    		StringBuffer b = new StringBuffer()	;
    		b.append(module).append("[").append(clazz.getName()).append("]");

    		return getTrace(b.toString());
    	}
    	return getTrace(module);
    	
    }

    @Override
    public boolean isEnabled(int level) {
        return level <= this.levelMax;
    }

    /**
     * Set the maximum trace file size in bytes.
     *
     * @param max the maximum size
     */
    public void setMaxFileSize(int max) {
        this.maxFileSize = max;
    }

    /**
     * Set the trace level to use for System.out
     *
     * @param level the new level
     */
    public void setLevelSystemOut(int level) {
        levelSystemOut = level;
        updateLogLevel();
    }

 

    

    private synchronized String format(String module, String s) {
        if (dateFormat == null) {
            dateFormat = new SimpleDateFormat("MM-dd HH:mm:ss ");
        }
        return dateFormat.format(new Date()) + module + " - " + s;
    }

    @Override
    public void write(int level, String module, String s) {
        if (level <= levelSystemOut || level > this.levelMax) {
            // level <= levelSystemOut: the system out level is set higher
            // level > this.level: the level for this module is set higher
            sysOut.println(format(module, s));            
        }
        if (fileName != null) {
            if (level <= logLevel) {            	
            	writeFile(format(module, s));
            }
        }
    }
    
    @Override
	public void write(int level,String module, String format, Object... objects) {
    	  if (level <= levelSystemOut || level > this.levelMax) {
              // level <= levelSystemOut: the system out level is set higher
              // level > this.level: the level for this module is set higher
    		  FormattingTuple format2 = MessageFormatter.arrayFormat(format, objects);
    		  sysOut.println(format(module, format2.getMessage()));
          }
    	  
          if (fileName != null) {
              if (level <= logLevel) {            	
        		FormattingTuple format2 = MessageFormatter.arrayFormat(format, objects);
              	writeFile(format(module, format2.getMessage()));
              }
          }
	}

	
    /**
     * 将目标字符串写入文件
     * @param s
     * @param t
     */
    private synchronized void writeFile(String s) {
        try {
            if (checkSize++ >= CHECK_SIZE_EACH_WRITES) {
                checkSize = 0;
                closeWriter();
                
                File file = new File(fileName);
                
                if (maxFileSize > 0 && file.length() > maxFileSize) {
                    String old = fileName + ".old";
                    //删除旧文件
                    File fileOld = new File(old);
                    if(fileOld.exists())fileOld.delete();
                    
                    //MOVE TO
                    file.renameTo(fileOld);
                }
            }
            if (!openWriter()) {
                return;
            }
            printWriter.println(s);
            
            printWriter.flush();
            if (closed) {
                closeWriter();
            }
        } catch (Exception e) {
            logWritingError(e);
        }
    }
    
    private void logWritingError(Exception e) {
        if (writingErrorLogged) {
            return;
        }
        writingErrorLogged = true;
        //Exception se = DbException.get(ErrorCode.TRACE_FILE_ERROR_2, e, fileName, e.toString());
        // print this error only once
        fileName = null;
        sysOut.println(e);
        e.printStackTrace();
    }
    
    private boolean openWriter() {
        if (printWriter == null) {
        	//建立文件
            try {
            	File file = new File(fileName);
            	if( file.exists() && ! file.canWrite() ){
            		return false;
            	}
            	FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileWriter = IOUtils.getBufferedWriter(fileOutputStream);
                printWriter = new PrintWriter(fileWriter, true);
            } catch (Exception e) {
                logWritingError(e);
                return false;
            }
        }
        return true;
    }
    

    private synchronized void closeWriter() {
        if (printWriter != null) {
            printWriter.flush();
            printWriter.close();
            printWriter = null;
        }
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                // ignore
            }
            fileWriter = null;
        }
    }

    /**
     * Close the writers, and the files if required. It is still possible to
     * write after closing, however after each write the file is closed again
     * (slowing down tracing).
     */
    public void close() {
        closeWriter();
        closed = true;
    }

    @Override
    public void setName(String name) {
    	this.module = name;
    }

}
