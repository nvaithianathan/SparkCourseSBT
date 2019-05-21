package com.spark.processing

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.lit

object Tubular {

  def withGoodVibes()(df: DataFrame): DataFrame = {
    df.withColumn(
      "chi",
      lit("happy")
    )
  }

}
