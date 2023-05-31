package com.chatgpt.masterclass.datacollectionlibrary.utils
import android.app.WallpaperManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.service.wallpaper.WallpaperService
import android.os.Build
import android.os.Process
import android.util.Log
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun getTimeStamp(): String {
    // current time in milis
    val currentTimeMillis = System.currentTimeMillis()
    //timestamp
    val timeStamp = java.sql.Timestamp(currentTimeMillis)

    return timeStamp.toString()
}

// get current wallpaper name
fun getCurrentWallpaperName(context: Context): String? {
    val wallpaperManager = WallpaperManager.getInstance(context)

    // Get the currently set wallpaper's component name
    val wallpaperInfo = wallpaperManager.wallpaperInfo
    if (wallpaperInfo != null) {
        // If the wallpaper is live wallpaper, return the component name
        return wallpaperInfo.packageName
    } else {
        // If the wallpaper is static, retrieve its resource name from the wallpaper URI
        val wallpaperUri = wallpaperManager.wallpaperInfo?.settingsActivity
        if (wallpaperUri != null) {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.component = ComponentName.unflattenFromString(wallpaperUri)
            val resolveInfo: ResolveInfo? = context.packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY)
            if (resolveInfo != null) {
                return resolveInfo.loadLabel(context.packageManager)?.toString()
            }
        }
    }

    return null
}



fun getCurrentScreenWallpaperName(context: Context): String? {
    val wallpaperManager = WallpaperManager.getInstance(context)

    // Get the currently set wallpaper's component name
    val wallpaperInfo = wallpaperManager.wallpaperInfo
    if (wallpaperInfo != null) {
        // If the wallpaper is a live wallpaper, return the component name
        return wallpaperInfo.packageName
    } else {
        // If the wallpaper is a static wallpaper, retrieve its resource name from the wallpaper URI
        val wallpaperService = WallpaperService::class.java
        val intent = Intent(WallpaperService.SERVICE_INTERFACE)
        val resolveInfoList: List<ResolveInfo> = context.packageManager.queryIntentServices(intent, PackageManager.GET_META_DATA)
        for (resolveInfo in resolveInfoList) {
            val metaData = resolveInfo.serviceInfo.metaData
            if (metaData != null && metaData.containsKey("android.service.wallpaper")) {
                val componentName = ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name)
                if (wallpaperManager.wallpaperInfo?.component == componentName) {
                    return resolveInfo.loadLabel(context.packageManager)?.toString()
                }
            }
        }
    }

    return null
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
 // extention function of getting


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



//getCpuClockSpeed function retrieves the current CPU clock speed of the device. It reads the /proc/cpuinfo file for the current process ID

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
