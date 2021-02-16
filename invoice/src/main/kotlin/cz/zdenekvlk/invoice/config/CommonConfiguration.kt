package cz.zdenekvlk.invoice.config

import org.h2.tools.Server
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.sql.SQLException

@Configuration
class CommonConfiguration {

    @Bean(initMethod = "start", destroyMethod = "stop")
    @Throws(SQLException::class)
    fun inMemoryH2DatabaseaServer(): Server {
        return Server.createTcpServer(
            "-tcp", "-tcpAllowOthers", "-tcpPort", "9098"
        )
    }
}