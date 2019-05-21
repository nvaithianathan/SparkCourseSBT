package com.spark.processing


import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, desc}

import com.spark.processing.util.{Logging}



object MainRun extends Logging{

  def main(args: Array[String]) {

    println("Inside MainRun Works 1111 ::: ")

    val mypath = "/Users/nvaithianathan/Documents/Nat/Learning/Spark/Spark-The-Definitive-Guide-master/data/flight-data/csv/2011-summary.csv"

    val spark = SparkSession
      .builder()
      .appName("SparkCsvReadExample")
      .master("local")
      .getOrCreate()

    //spark.sparkContext.setLogLevel("ERROR")


    println("Inside MainRun Works 2222 ::: ")

    logInfo("Logging infor messages :::")



    /*logInfo("start -- Info")

    logDebug("This is very convenient -- Debugging;-)")
*/
    //logError("This is very convenient -- Erroring;-)")



    val df = spark.read.format("csv")
      .option("header", "true")
      .option("mode", "FAILFAST")
      .option("inferSchema", "true")
      .load(mypath)

      println("11111111111111 df count ::: "+ df.count())

     val cnt1 = df.distinct().count()

    println("222222222 df distinct count ::: "+ cnt1)


    //val newDf = df.filter(col("ORIGIN_COUNTRY_NAME") === "United States").cache()

    val newDf = df.groupBy(col("ORIGIN_COUNTRY_NAME") ).count().orderBy(desc("count"))

    println("DF filtered count ::: " + newDf.count)

    logInfo("Dataframe count :::" + newDf.count)

    val disp : Int = newDf.count.toInt


    newDf.show(disp, false)



  }
}
