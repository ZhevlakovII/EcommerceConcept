plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = AppConfig.namespace
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicatonId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(project(Dependencies.Modules.domain))

    implementation(Dependencies.AndroidComponents.ktxCore)
    implementation(Dependencies.AndroidComponents.appCompat)
    implementation(Dependencies.AndroidComponents.material)
    implementation(Dependencies.AndroidComponents.constraint)

    implementation(Dependencies.Navigation.navigation)
    implementation(Dependencies.Navigation.navigationUI)

    implementation(Dependencies.Lifecycle.livedata)
    implementation(Dependencies.Lifecycle.viewmodel)
}