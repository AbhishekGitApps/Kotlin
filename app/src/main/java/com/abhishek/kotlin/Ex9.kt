package com.abhishek.kotlin

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import java.util.concurrent.TimeUnit

class Ex9 : AppCompatActivity() {

    var mPlayer: MediaPlayer? = null
    private var oTime = 0
    private var sTime: Int = 0
    private var eTime: Int = 0
    private var fTime: Int = 5000
    private var bTime: Int = 5000
    private val hdlr: Handler = Handler()

    lateinit var song_name:TextView
    lateinit var seekbar:SeekBar
    lateinit var buttonPause:ImageButton
    lateinit var buttonPlay:ImageButton
    lateinit var song_time:TextView
    lateinit var start_time:TextView
    lateinit var buttonForward:ImageButton
    lateinit var backButton:ImageButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex9)

        song_name = findViewById(R.id.song_name)
        seekbar = findViewById(R.id.seekbar)
        buttonPause = findViewById(R.id.buttonPause)
        buttonPlay = findViewById(R.id.buttonPlay)
        song_time = findViewById(R.id.song_time)
        start_time = findViewById(R.id.start_time)
        buttonForward = findViewById(R.id.buttonForward)
        backButton = findViewById(R.id.backButton)

        song_name.text = "Fatiha"

        mPlayer = MediaPlayer.create(this, R.raw.song)
        seekbar!!.setClickable(false)
        buttonPause!!.isEnabled = false

        buttonPlay!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(applicationContext, "Audio Playing", Toast.LENGTH_SHORT).show()
                mPlayer!!.start()
                eTime = mPlayer!!.duration.toLong().toInt()
                sTime = mPlayer!!.currentPosition.toLong().toInt()

                if (oTime == 0) {
                    seekbar!!.setMax(eTime)
                    oTime = 1
                }

                song_time!!.text = String.format(
                    "%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes(eTime.toLong()),
                    TimeUnit.MILLISECONDS.toSeconds(eTime.toLong()) - TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(eTime.toLong())))

                start_time!!.text = String.format(
                    "%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes(sTime.toLong()),
                    TimeUnit.MILLISECONDS.toSeconds(sTime.toLong()) - TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(sTime.toLong())))

                seekbar?.setProgress(sTime)
                hdlr.postDelayed(updateSongTime, 100)
                buttonPause!!.isEnabled = true
                buttonPlay!!.isEnabled = false
            }
        })

        buttonPause!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                mPlayer!!.pause()
                buttonPause!!.isEnabled = false
                buttonPlay!!.isEnabled = true
                Toast.makeText(applicationContext, "Audio Paused", Toast.LENGTH_SHORT).show()
            }
        })

        buttonForward?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if (sTime + fTime <= eTime) {
                    sTime = sTime + fTime
                    mPlayer!!.seekTo(sTime)
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Cannot jump forward 5 seconds",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                if (!buttonPlay!!.isEnabled) {
                    buttonPlay!!.isEnabled = true
                }
            }
        })

        backButton!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if (sTime - bTime > 0) {
                    sTime = sTime - bTime
                    mPlayer!!.seekTo(sTime)
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Cannot jump backward 5 seconds",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                if (!buttonPlay!!.isEnabled) {
                    buttonPlay!!.isEnabled = true
                }
            }
        })

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {


            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mPlayer!!.seekTo(progress)

                }


            }

            override fun onStartTrackingTouch(seekBar: SeekBar?)
            {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?)
            {

            }

        })

        mPlayer!!.setOnCompletionListener(object : MediaPlayer.OnCompletionListener {
            override fun onCompletion(mp: MediaPlayer?) {
                try {
                    mPlayer!!.start()
                    seekbar.progress = sTime
                    mPlayer!!.isLooping = true
                } catch (e: Exception) {
                    Toast.makeText(applicationContext, e.toString(), Toast.LENGTH_SHORT).show()
                }
            }

        })
    }

    private val updateSongTime: Runnable = object : Runnable {
        override fun run() {
            sTime = mPlayer!!.currentPosition
            start_time!!.text = String.format(
                "%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes(sTime.toLong()),
                TimeUnit.MILLISECONDS.toSeconds(sTime.toLong()) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(sTime.toLong())
                )
            )
            seekbar!!.progress = sTime
            hdlr.postDelayed(this, 100)
        }
    }


}