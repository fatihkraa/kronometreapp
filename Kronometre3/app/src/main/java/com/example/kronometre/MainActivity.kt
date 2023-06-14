package com.example.kronometre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitMainBinding.inflate(LayoutInflater)
        setContentView(binding.root)
        var zamanidurdur:Long=0
        binding.btnStart.setOnClickListener{
            binding.kronometre.base=SystemClock.elapsedRealtime()+zamanidurdur
            binding.kronometre.start()
            binding.btnStart.visibility= View.GONE
            binding.btnPause.visibility=View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.PAUSEE))

        }
        binding.btnPause.setOnClickListener{
            zamanidurdur=binding.kronometre.base-SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            binding.btnPause.visibility= View.GONE
            binding.btnStart.visibility=View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.STARTT))

        }
        binding.btnReset.setOnClickListener{
            binding.kronometre.base = SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            zamanidurdur = 0
            binding.btnPause.visibility= View.GONE
            binding.btnStart.visibility=View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.STARTT))

        }


    }
}