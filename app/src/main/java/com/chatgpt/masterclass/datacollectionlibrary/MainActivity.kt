package com.chatgpt.masterclass.datacollectionlibrary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chatgpt.masterclass.datacollectionlibrary.databinding.ActivityMainBinding
import com.data.collection.library.Toaster


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // as we have only one layout activity_main.xml
        binding = ActivityMainBinding.inflate(layoutInflater)
        // binding.root returns the root layout,
        // which is activity_main.xml file itself
        setContentView(binding.root)
        Toaster.simpleToast(this, "This is data Collection Library")

        // set current timestamp
        binding.timeStampTv.text = Toaster.getTimeStamp()

        // set device name
        val deviceName = Toaster.getDeviceName()
        binding.deviceNameTv.text = deviceName

        // set Os Version
        val androidOSVersion = Toaster.getAndroidOSVersion()
        binding.versionOsTv.text = androidOSVersion


        // build version
        val buildVersion = Toaster.getBuildVersion()
        binding.buildVersionTv.text = buildVersion.toString()

        // cpu clock speed
        val cpuClockSpeed = Toaster.getCpuClockSpeed()
        binding.cpuClockSPeedTv.text = cpuClockSpeed
        // set manufecturer name
        binding.manufacturerNameTv.text = Toaster.getManufacturerName()

    }
}