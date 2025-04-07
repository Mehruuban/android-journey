plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.mehru.newsapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.mehru.newsapp"
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation ("com.github.KwabenBerko:News-API-Java:1.0.2")
    implementation ("com.github.KwabenBerko:News-API-Java:1.0.2")


    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("androidx.core:core:1.12.0")
    implementation ("com.google.android.material:material:1.11.0")
    implementation ("com.squareup.picasso:picasso:2.8")

    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.10.0")


    //for circle imageview
        implementation ("de.hdodenhof:circleimageview:3.1.0")


}