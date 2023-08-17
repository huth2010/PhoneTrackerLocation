import com.google.devtools.ksp.gradle.model.Ksp
import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("androidx.navigation.safeargs.kotlin")

}
// Load API keys from properties file
val apikeyPropsFile = file("apikey.properties")
val apikeyProps = Properties()
apikeyProps.load(apikeyPropsFile.inputStream())

android {
    namespace = "com.knd.duantotnghiep.phonetrackerlocation"
    compileSdk = 33
    android.buildFeatures.buildConfig = true
    defaultConfig {
        applicationId = "com.knd.duantotnghiep.phonetrackerlocation"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        buildConfigField(
//            "String",
//            "GOOGLE_MAPS_API_KEY",
//            apikeyProps["googleMapsApiKey"].toString()
//        )
        buildConfigField("String", "GG_APP_OPEN", apikeyProps["GG_APP_OPEN"].toString())
        buildConfigField("String", "GG_BANNER", apikeyProps["GG_BANNER"].toString())
        buildConfigField("String", "GG_NATIVE", apikeyProps["GG_NATIVE"].toString())
        buildConfigField("String", "GG_FULL", apikeyProps["GG_FULL"].toString())
        buildConfigField("String", "GG_REWARDED", apikeyProps["GG_REWARDED"].toString())
    }

    buildTypes {

        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    //hilt-dagger
    kapt("com.google.dagger:hilt-android-compiler:2.44")
    implementation("com.google.dagger:hilt-android:2.44")

    //Live-data
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    //LoadImage
    implementation("com.github.bumptech.glide:glide:4.15.1")
    implementation("com.squareup.picasso:picasso:2.71828")

    //Paging
    implementation("androidx.paging:paging-runtime:3.1.1")

    //Lottie
    implementation("com.airbnb.android:lottie:6.0.0")

    //GG map
    implementation("com.google.gms:google-services:4.3.15")
    implementation("com.google.android.gms:play-services-maps:18.1.0")
    implementation("com.google.android.gms:play-services-location:21.0.1")

    //Room Database
    implementation("androidx.room:room-runtime:2.5.2")
    implementation("androidx.room:room-ktx:2.5.2")
    ksp("androidx.room:room-compiler:2.5.2")

    //Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.6.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.6.0")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
kapt {
    correctErrorTypes = true
}