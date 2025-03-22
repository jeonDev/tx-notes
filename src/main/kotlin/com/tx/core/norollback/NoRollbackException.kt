package com.tx.core.norollback

import java.lang.RuntimeException


class NoRollbackException(cause:Throwable): RuntimeException(cause) {


}