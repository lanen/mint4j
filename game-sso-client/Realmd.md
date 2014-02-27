
`game-sso-client` 是游戏资源的提供点。

从账号服务器(腾讯过来的账号)过来的玩家，需要进行激活选取，才能进行游戏。账号服务器可以对接过个游戏，进到游戏的`j_spring_cas_security_check` 页面，验证

激活游戏是通过Web服务的方式进行进行。

ADMIN_ROLE

/realmd/{1}/status

/realmd/{1}/uptime

/realmd/{1}/gm/

USER

/realmd/list

/realmd/{1}/active/who. post key

/realmd/{1}/play
