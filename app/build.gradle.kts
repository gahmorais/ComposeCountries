plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
}


val nav_compose_version: String by project
val koin_version: String by project
val activity_version: String by project
val ktor_version: String by project
val logback_version: String by project
val timber_version: String by project
val kotlin_version: String by project
val lifecycle_version: String by project
val compose_bom: String by project
val slf4j_version: String by project
val API_ADDRESS: String by project
val okhttp_version: String by project
val coil_version: String by project

android {
  namespace = "br.com.backupautomacao.exploringandroid"
  compileSdk = 34

  defaultConfig {
    buildConfigField("String", "API_ADDRESS", API_ADDRESS)
    applicationId = "br.com.backupautomacao.exploringandroid"
    minSdk = 24
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  buildTypes {
    debug {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
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
    buildConfig = true
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.4.3"
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {
  //Kotlin
  implementation("androidx.core:core-ktx:$kotlin_version")

  //Lifecycle
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")

  //Jetpack Compose
  implementation("androidx.activity:activity-compose:$activity_version")
  implementation(platform("androidx.compose:compose-bom:$compose_bom"))
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.ui:ui-graphics")
  implementation("androidx.compose.ui:ui-tooling-preview")
  implementation("androidx.navigation:navigation-compose:$nav_compose_version")
  implementation("androidx.compose.material3:material3")
  androidTestImplementation("androidx.compose.ui:ui-test-junit4")
  debugImplementation("androidx.compose.ui:ui-tooling")
  debugImplementation("androidx.compose.ui:ui-test-manifest")
  androidTestImplementation(platform("androidx.compose:compose-bom:$compose_bom"))

  //Dependency Injection
  implementation("io.insert-koin:koin-android:$koin_version")
  implementation("io.insert-koin:koin-androidx-compose:$koin_version")

  //Ktor
  implementation("io.ktor:ktor-serialization-gson:$ktor_version")
  implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
  implementation("io.ktor:ktor-client-core:$ktor_version")
  implementation("io.ktor:ktor-client-cio:$ktor_version")
  implementation("io.ktor:ktor-client-auth:$ktor_version")
  implementation("io.ktor:ktor-client-logging:$ktor_version")
  implementation("io.ktor:ktor-client-okhttp:$ktor_version")

  //OkHttp
  implementation("com.squareup.okhttp3:logging-interceptor:$okhttp_version")

  //Logger
  implementation("com.jakewharton.timber:timber:$timber_version")
  implementation("org.slf4j:slf4j-simple:$slf4j_version")

  //Coil
  implementation("io.coil-kt:coil-compose:$coil_version")

}