package com.example.taskmanager.ui.onBoarding.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.example.taskmanager.R
import com.example.taskmanager.databinding.ItemBordingBinding
import com.example.taskmanager.ui.model.OnBoard

class OnBoardingAdapter(private val context: Context, private val onClick: ()-> Unit)
       : RecyclerView.Adapter<OnBoardingAdapter.onBoardingViewHolder>() {
    private val data = arrayListOf<OnBoard>(
        OnBoard("https://static.vecteezy.com/system/resources/thumbnails/007/141/522/small_2x/fast-food-set-with-hamburger-and-hotdog-free-vector.jpg","Fast Food"),
        OnBoard("https://img.freepik.com/premium-vector/fast-online-food-order-and-package-delivery-service-fast-food-shipping-isometric-courier-with-pizza_108855-3468.jpg","Fast Delivery"),
        OnBoard("https://cdni.iconscout.com/illustration/premium/thumb/payment-method-4438116-3685826.png","Easy Payment"),
    )



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): onBoardingViewHolder {
        return onBoardingViewHolder(ItemBordingBinding.inflate(LayoutInflater.from(parent.context),parent,
            false))
    }

    override fun onBindViewHolder(holder: onBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
    inner class onBoardingViewHolder(private val binding: ItemBordingBinding):
        RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bind(onBoard: OnBoard) {
            Glide.with(binding.imgBoarding).load(onBoard.image).into(binding.imgBoarding)

            binding.tvTitles.text = onBoard.titles
            if(adapterPosition == data.lastIndex){
                binding.skip.text = context.getString(R.string.next)
            } else  binding.skip.text = context.getString(R.string.skip)
           binding.skip.setOnClickListener{
               onClick()

           }

        }

    }
}