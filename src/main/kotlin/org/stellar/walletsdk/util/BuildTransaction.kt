package org.stellar.walletsdk.util

import org.stellar.sdk.Network
import org.stellar.sdk.Operation
import org.stellar.sdk.Server
import org.stellar.sdk.Transaction

fun buildTransaction(
  sourceAddress: String,
  server: Server,
  network: Network,
  operations: List<Operation>
): Transaction {
  val sourceAccount = fetchAccount(sourceAddress, server)

  // TODO: add memo
  // TODO: update max fee
  // TODO: add time bounds

  return Transaction.Builder(sourceAccount, network)
    .addOperations(operations)
    .setBaseFee(500)
    .setTimeout(180)
    .build()
}