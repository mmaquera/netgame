plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = 31
    buildToolsVersion = "30.0.3"
    defaultConfig {
        applicationId = "com.mmaquera.netgame"
        minSdk = 21
        targetSdk = 31
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions{
        jvmTarget = "1.8"
    }

    composeOptions{
        kotlinCompilerExtensionVersion = "1.3.2"
    }
}

dependencies {
    implementation(fileTree("libs") { include("*.jar") })

    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":usecases"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}")
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

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}")

    //implementations for compose
    implementation("androidx.activity:activity-compose:1.5.1")
    implementation("androidx.compose.material:material:1.2.1")
    implementation("androidx.compose.animation:animation:1.2.1")
    implementation("androidx.compose.ui:ui-tooling:1.2.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")

    implementation("com.google.accompanist:accompanist-appcompat-theme:0.25.1")

}
