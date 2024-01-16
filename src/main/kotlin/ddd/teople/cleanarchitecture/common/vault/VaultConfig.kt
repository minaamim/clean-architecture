package ddd.teople.cleanarchitecture.common.vault

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.vault.authentication.AppRoleAuthentication
import org.springframework.vault.authentication.AppRoleAuthenticationOptions
import org.springframework.vault.authentication.ClientAuthentication
import org.springframework.vault.client.VaultEndpoint
import org.springframework.vault.config.AbstractVaultConfiguration
import java.net.URI

@Primary
@Configuration
class VaultConfig : AbstractVaultConfiguration() {
    override fun vaultEndpoint(): VaultEndpoint {
        val vaultUri = environment.getProperty("vault.uri") ?: throw NullPointerException("vault uri가 없습니다.")
        return VaultEndpoint.from(URI(vaultUri))
    }

    override fun clientAuthentication(): ClientAuthentication {
        // AppRole
        val options = AppRoleAuthenticationOptions.builder()
            .roleId(
                AppRoleAuthenticationOptions.RoleId.provided(
                    environment.getProperty("vault.app-role.role-id") ?: throw NullPointerException("vault role-id가 없습니다.")
                )
            )
            .secretId(
                AppRoleAuthenticationOptions.SecretId.provided(
                    environment.getProperty("vault.app-role.secret-id") ?: throw NullPointerException("vault secret-id가 없습니다.")
                )
            )
            .build()

            return AppRoleAuthentication(options, restOperations())
    }
}