package com.example.foodshop.data.network

import com.example.foodshop.data.network.models.ResponseWrapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

/**
 * Выполняет безопасный сетевой вызов, обрабатывая ошибки и возвращая результат в обертке [ResponseWrapper].
 *
 * @param dispatcher диспетчер корутин, используемый для выполнения сетевого вызова.
 * @param apiCall сетевой вызов, представленный в виде функции-прерывания.
 * @return [ResponseWrapper] - обертка, содержащая результат сетевого вызова или информацию об ошибке.
 */
suspend fun <T> safeNetworkCall(
    dispatcher : CoroutineDispatcher,
    apiCall: suspend () -> T
) : ResponseWrapper<T> {
    return withContext(dispatcher){
        try{
            ResponseWrapper.Success(apiCall.invoke())
        } catch (throwable : Throwable){
            when(throwable){
                is IOException -> ResponseWrapper.NetworkError
                is HttpException -> {
                    val code = throwable.code()
                    ResponseWrapper.GenericError(code)
                }
                else -> ResponseWrapper.GenericError(null)
            }
        }
    }
}