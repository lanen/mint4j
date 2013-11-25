package evanq.game.helper;

/**
 * 
 * 生成器的接口
 * 
 * @author Evan
 *
 * @param <Product>
 */
public interface Generator<Product> {

	/**
	 * 生成目标对象
	 * @return
	 */
	public Product generate();
	
	/**
	 * 
	 * 回收目标对象
	 * 
	 * @param product
	 * @return
	 */
	public boolean recycle(Product product);
	
}
