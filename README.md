# DataCollectionLibrary
data collection
-> Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
....gradle

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  .......
 -> Step 2. Add the dependency 
 
.....gradle


	dependencies {
 
	        implementation 'com.github.madil007:DataCollectionLibrary:Tag'
	 
	}


 [![](https://jitpack.io/v/madil007/DataCollectionLibrary.svg)](https://jitpack.io/#madil007/DataCollectionLibrary)

