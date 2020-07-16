plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.3")
    defaultConfig {
        applicationId = "com.mmaquera.netgame"
        minSdkVersion(19)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(fileTree("libs") { include("*.jar") })

    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":usecases"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}")
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.core:core-ktx:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("com.google.android.material:material:1.1.0")
    testImplementation("junit:junit:4.13")
    androidTestImplementation("androidx.test:runner:1.2.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")

    implementation("androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}")
    implementation("androidx.navigation:navigation-ui-ktx:${Versions.navVersion}")

    api("com.google.dagger:dagger:${Versions.dagger2}")
    kapt("com.google.dagger:dagger-compiler:${Versions.dagger2}")

    implementation("com.squareup.retrofit2:retrofit:${Versions.retrofit2}")
    implementation("com.squareup.retrofit2:converter-gson:${Versions.retrofit2}")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}")
}
