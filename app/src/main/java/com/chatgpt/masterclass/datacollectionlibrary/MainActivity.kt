package com.chatgpt.masterclass.datacollectionlibrary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chatgpt.masterclass.datacollectionlibrary.databinding.ActivityMainBinding
import com.chatgpt.masterclass.datacollectionlibrary.utils.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // as we have only one layout activity_main.xml
        binding = ActivityMainBinding.inflate(layoutInflater)
        // binding.root returns the root layout,
        // which is activity_main.xml file itself
        setContentView(binding.root)

        // set current timestamp
        binding.timeStampTv.text = getTimeStamp()

        // set device name
        val deviceName = getDeviceName()
        binding.deviceNameTv.text = deviceName

        // set Os Version
        val androidOSVersion = getAndroidOSVersion()
        binding.versionOsTv.text = androidOSVersion


        // build version
        val buildVersion = getBuildVersion()
        binding.buildVersionTv.text = buildVersion.toString()

        // cpu clock speed
        val cpuClockSpeed = getCpuClockSpeed()
        binding.cpuClockSPeedTv.text = cpuClockSpeed
        // set manufecturer name
        binding.manufacturerNameTv.text = getManufacturerName()


    }
}