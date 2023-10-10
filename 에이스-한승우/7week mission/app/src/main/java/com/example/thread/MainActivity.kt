package com.example.homework7

import android.app.Activity
import android.media.SoundPool
import android.os.*
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.homework7.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var total = 15 // 전체 시간 (초 기준)
    private var started = false

    private val soundPool = SoundPool.Builder().build()
    private var tickingSound: Int? = null
    private var bellSound: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startTimer()
        stopTimer()
        initSounds() // 사운드 로드
    }

    private fun initSounds() {
        tickingSound = soundPool.load(this, R.raw.timer_ticking, 1)
        bellSound = soundPool.load(this, R.raw.timer_bell, 1)
    }

    private fun startTimer() {
        // 핸들러를 사용하면 원래 스레드가 아닌 다른 스레드에서도 뷰를 다룰 수 있음
        val handler = Handler(Looper.getMainLooper())

        binding.startBtn.setOnClickListener {
            if (started == false) {
                started = true

                Thread() {
                    while(started) {
                        Thread.sleep(1000)
                        if (total == 0) {
                            started = false
                            soundPool.autoPause()
                            bellSound?.let { soundId ->
                                soundPool.play(soundId, 1F, 1F, 0, 0, 1F)
                            }
                        }
                        if (started) {
                            total -= 1
                            handler.post {
                                val minute = String.format("%02d", total / 60)
                                val second = String.format("%02d", total % 60)
                                binding.timer.text = "$minute:$second"

                                tickingSound?.let { soundId ->
                                    soundPool.play(soundId, 1F, 1F, 0, -1, 1F)
                                }
                            }
                        }
                    }
                }.start()
            }
        }
    }

    private fun stopTimer() {
        binding.stopBtn.setOnClickListener {
            started = false
            soundPool.autoPause()
        }
    }
}