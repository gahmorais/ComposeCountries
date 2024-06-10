import java.io.FileInputStream
import java.util.Properties

plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
}

val koin_version: String by project
val ktor_version: String by project
val slf4j_version: String by project
val timber_version: String by project
val okhttp_version: String by project
val coil_version: String by project
android {
  namespace = "br.com.backupautomacao.exploringandroid"
  compileSdk = 34

  defaultConfig {
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
      val properties = Properties()
      properties.load(FileInputStream(rootProject.file("local.properties")))
      val apiToken = properties["API_TOKEN"] as String
      resValue("string", "API_TOKEN", apiToken)
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

  implementation("androidx.core:core-ktx:1.9.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.1")
  implementation("androidx.activity:activity-compose:1.9.0")
  implementation(platform("androidx.compose:compose-bom:2023.03.00"))
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.ui:ui-graphics")
  implementation("androidx.compose.ui:ui-tooling-preview")
  implementation("androidx.compose.material3:material3")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
  androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
  androidTestImplementation("androidx.compose.ui:ui-test-junit4")
  debugImplementation("androidx.compose.ui:ui-tooling")
  debugImplementation("androidx.compose.ui:ui-test-manifest")

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
  implementation("org.slf4j:slf4j-simple:$slf4j_version")
  implementation("io.ktor:ktor-client-okhttp:$ktor_version")
  implementation("com.squareup.okhttp3:logging-interceptor:$okhttp_version")

  //Logger
  implementation("com.jakewharton.timber:timber:$timber_version")

  //Coil
  implementation("io.coil-kt:coil-compose:$coil_version")
}