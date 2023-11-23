package com.waveofmymind.account.application

import com.waveofmymind.account.domain.Account
import com.waveofmymind.account.domain.AccountJpaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
@Transactional
class AccountService(
    private val accountRepository: AccountJpaRepository
) {

    @Transactional(readOnly = true)
    fun getAccount(userId: Long): FindAccountResponse {
        val account: Account =
            accountRepository.findByUserId(userId) ?: throw IllegalArgumentException("존재하지 않는 계좌입니다.")
        return FindAccountResponse.from(
            account.id,
            account.userId,
            account.name,
            account.accountNumber,
            account.balance
        )
    }

    fun createAccount(command: CreateAccountCommand): Long {
        accountRepository.findByUserIdAndName(command.userId, command.name)?.let {
            throw IllegalArgumentException("이미 계좌가 존재합니다.")
        }
        val account = Account.of(
            command.userId,
            command.name,
            command.password,
            generateAccountNumber()
        )
        return accountRepository.save(account).id
    }

    private fun generateAccountNumber(): String {
        return UUID.randomUUID().toString()
    }
}