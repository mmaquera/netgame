plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "com.mmaquera.netgame"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
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
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions{
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":usecases"))

    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("com.google.android.material:material:1.3.0")
    /*
    implementation ("androidx.activity:activity-ktx:1.2.3")
    implementation("androidx.fragment:fragment-ktx:1.3.3")*/
    /*
    testImplementation("junit:junit:4.13")
    androidTestImplementation("androidx.test:runner:1.2.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")*/

    implementation("androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}")
    implementation("androidx.navigation:navigation-ui-ktx:${Versions.navVersion}")

    implementation("com.google.dagger:hilt-android:${Versions.daggerHilt}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}")


    /*
    implementation("com.squareup.retrofit2:retrofit:${Versions.retrofit2}")
    implementation("com.squareup.retrofit2:converter-gson:${Versions.retrofit2}")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")*/

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    //compose
    val composeBom = platform("androidx.compose:compose-bom:2022.12.00")
    implementation(composeBom)
    implementation("androidx.compose.material:material:1.3.1")
    //implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.navigation:navigation-compose:2.5.3")

    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")

    // For Preview
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.3")
    debugImplementation("androidx.compose.ui:ui-tooling:1.3.3")
    // Optional - Integration with activities
    implementation("androidx.activity:activity-compose:1.5.1")

}
