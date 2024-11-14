package com.example.final_tp

import android.app.Application

class TpFinalMovileApp: Application() {
  companion object {
    lateinit var instance: TpFinalMovileApp
  }

  override fun onCreate() {
    super.onCreate()
    instance = this
  }
}