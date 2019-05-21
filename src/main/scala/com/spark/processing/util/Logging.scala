package com.spark.processing.util

import com.arpnetworking.steno.{LogBuilder, LoggerFactory}

private[processing] trait Logging {

    @transient private lazy val logger = LoggerFactory.getLogger(this.getClass.getName.stripSuffix("$"))

    protected def logInfo(msg: String): Unit =
      logger.info(msg)

    protected def logInfo(msg: String, dataKey: String, dataValue: Any): Unit =
      log(logger.info, msg, Map(dataKey -> dataValue))

    protected def logError(msg: String): Unit =
      logger.error(msg)

    protected def logError(msg: String, ex: Throwable): Unit =
      logger.error(msg, ex)

    protected def logError(msg: String, key: String, value: Any): Unit =
      log(logger.error, msg, Map(key -> value))

    protected def logError(msg: String, key: String, value: Any, ex: Throwable): Unit =
      log(logger.error, msg, Map(key -> value), Some(ex))

    protected def logError(msg: String, data: Map[String, AnyRef] , ex: Throwable): Unit =
      log(logger.error, msg, data, Some(ex))

    protected def logError(event: String, msg: String, dataKey: String, dataValue: Any): Unit =
      logger.error(event, msg, dataKey, dataValue)

    protected def logError(event: String, msg: String, dataKey: String, dataValue: Any, ex: Throwable): Unit =
      logger.error(event, msg, dataKey, dataValue, ex)

    protected def logDebug(msg: String): Unit =
      logger.debug(msg)

    protected def logDebug(msg: String, dataKey: String, dataValue: Any): Unit =
      log(logger.debug, msg, Map(dataKey -> dataValue))

    protected def logDebug(msg: String, key1: String, value1: Any, key2: String, value2: Any): Unit =
      log(logger.debug(), msg, Map(key1 -> value1, key2 -> value2))

    protected def logWarn(msg: String): Unit =
      logger.warn(msg)

    protected def logWarn(msg: String, key1: String, value1: Any): Unit =
      log(logger.warn, msg, Map(key1 -> value1))

    protected def logWarn(msg: String, data: Map[String, Any]): Unit =
      log(logger.warn, msg, data)


    private def log(builder: LogBuilder, msg: String, data: Map[String, Any] , ex: Option[Throwable] = None): Unit = {
      builder.setMessage(msg)
      ex.foreach(builder.setThrowable)
      data.foreach{ case (k, v) => builder.addData(k, v)}
      builder.log()
    }

  }
