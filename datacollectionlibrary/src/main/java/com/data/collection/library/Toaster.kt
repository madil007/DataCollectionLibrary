package com.data.collection.library

import android.content.Context
import android.os.Build
import android.os.Process
import android.util.Log
import android.widget.Toast
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

object Toaster {
     fun simpleToast(context: Context, message:String){
        Toast.makeText(context, "This is simple toast", Toast.LENGTH_SHORT).show()
    }

     fun getTimeStamp(): String {
         // current time in milis
         val currentTimeMillis = System.currentTimeMillis()
         //timestamp
         val timeStamp = java.sql.Timestamp(currentTimeMillis)

         return timeStamp.toString()
     }


     // get device name

     fun getDeviceName(): String {
         val manufacturer = Build.MANUFACTURER
         val model = Build.MODEL
         return if (model.startsWith(manufacturer)) {
             model
         } else {
             "$manufacturer $model"
         }
     }

     // get the company name who manufacture the device

     fun getManufacturerName(): String {
         return Build.MANUFACTURER
     }

     // android OSVersion
     fun getAndroidOSVersion(): String {
         return Build.VERSION.RELEASE
     }

     // get build version
     fun getBuildVersion(): Int {
         return Build.VERSION.SDK_INT
     }


     fun getCpuClockSpeed(): String {
         try {
             val pid = Process.myPid().toString()
             val cpuInfoFile = File("/proc/$pid/stat")
             val reader = BufferedReader(FileReader(cpuInfoFile))
             val cpuInfo = reader.readLine().split(" ").toTypedArray()
             reader.close()

             // CPU clock speed is the 14th value in the cpuInfo array
             val clockSpeed = cpuInfo[13]

             Log.d("clockSpeed", clockSpeed.toString())
             // Convert from Hz to MHz
             //  val clockSpeedMHz = clockSpeed.toLong() / 1000

             return "$clockSpeed"
             //  return "clockSpeedMHz MHz"
         } catch (e: Exception) {
             e.printStackTrace()
         }

         return "N/A"
     }

 }
