plugins {
    id(GradlePlugins.android)
    kotlin(GradlePlugins.kotlinAndroid)
    kotlin(GradlePlugins.kotlinApt)
    kotlin(GradlePlugins.kotlinExt)
    id(GradlePlugins.kotlinKapt)
    id(GradlePlugins.realm)
}

apply {
    plugin(GradlePlugins.navigationSafeKotlin)
}

android {
    compileSdkVersion(Android.targetSdk)
    flavorDimensions("default")

    defaultConfig {
        applicationId = Android.applicationId
        minSdkVersion(Android.minSdk)
        targetSdkVersion(Android.targetSdk)
        versionCode = Android.versionCode
        versionName = Android.versionName

        testInstrumentationRunner = AndroidJUnit.runner
    }

    buildTypes {
        getByName(BuildType.release) {
            isMinifyEnabled = BuildType.minifyRelease
            proguardFiles(BuildType.proguardRelease)
        }

        getByName(BuildType.debug) {
            isMinifyEnabled = BuildType.minifyDebug
            proguardFiles(BuildType.proguardDebug)
            isDebuggable = true
        }
    }

    productFlavors {
        create("develop") {
            matchingFallbacks = listOf("debug", "qa")
        }

        create("production") {
            matchingFallbacks = listOf("release")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    dataBinding {
        isEnabled = true
    }

    androidExtensions {
        isExperimental = true
    }
}

dependencies {
    // ktx core
    implementation(Libs.ktx)
    implementation(Libs.stdLib)

    // support
    implementation(Libs.supportAppCompat)
    implementation(Libs.supportAnnotations)
    implementation(Libs.supportCardview)
    implementation(Libs.supportDesign)
    implementation(Libs.supportRecyclerview)
    implementation(Libs.supportRecyclerviewSelection)
    implementation(Libs.supportLegacyV4)

    // lifecycle
    implementation(Libs.lifecycleExtensions)
    implementation(Libs.lifecycleLiveDataKtx)
    implementation(Libs.lifecycleViewModel)
    implementation(Libs.lifecycleSavedState)
    implementation(Libs.fragmentKtx)

    // Constraint Layout
    implementation(Libs.constraintlayout)

    // Glide
    implementation(Libs.glideRuntime)

    // Rx
    implementation(Libs.rxJava)
    implementation(Libs.rxAndroid)

    kapt(Libs.daggerProcessor)
    kapt(Libs.daggerCompiler)

    // Dagger 2
    implementation(Libs.daggerCore)
    implementation(Libs.daggerAndroid)
    implementation(Libs.daggerSupport)

    implementation(Libs.retrofitGson)
    implementation(Libs.retrofitRuntime)

    // Permission
    implementation(Libs.permission)

    // module
    implementation(project(Modules.domain)) {
        exclude(group = "com.example.cleanarchitecture", module = "domain")
    }
    implementation(project(Modules.data)) {
        exclude(group = "com.example.cleanarchitecture", module = "data")
    }

    // Navigation
    implementation(Libs.navigationUiKtx)
    implementation(Libs.navigationFragmentKtx)

    // coroutines
    implementation(Libs.coroutinesCore)
    implementation(Libs.coroutinesAndroid)

    //viewpager2
    implementation(Libs.viewpager2)

}