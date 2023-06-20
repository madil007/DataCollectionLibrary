package com.chatgpt.masterclass.datacollectionlibrary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chatgpt.masterclass.datacollectionlibrary.databinding.ActivityMainBinding
import com.data.collection.library.DataCollection


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // as we have only one layout activity_main.xml
        binding = ActivityMainBinding.inflate(layoutInflater)
        // binding.root returns the root layout,
        // which is activity_main.xml file itself
        setContentView(binding.root)
        DataCollection.simpleToast(this, "This is data Collection Library")

        // set current timestamp
        binding.timeStampTv.text = DataCollection.getTimeStamp()

        // set device name
        val deviceName = DataCollection.getDeviceName()
        binding.deviceNameTv.text = deviceName

        // set Os Version
        val androidOSVersion = DataCollection.getAndroidOSVersion()
        binding.versionOsTv.text = androidOSVersion


        // build version
        val buildVersion = DataCollection.getBuildVersion()
        binding.buildVersionTv.text = buildVersion.toString()

        // cpu clock speed
        val cpuClockSpeed = DataCollection.getCpuClockSpeed()
        binding.cpuClockSPeedTv.text = cpuClockSpeed
        // set manufecturer name
        binding.manufacturerNameTv.text = DataCollection.getManufacturerName()

    }
}