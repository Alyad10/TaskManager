package com.example.taskmanager.ui.profile.onBoarding.adapter

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
        OnBoard("https://ouch-cdn2.icons8.com/VbsTb9w7IRc3mkrragtZ2p_HUo25J0L8HMW3rcJPKNQ/rs:fit:256:192/czM6Ly9pY29uczgu/b3VjaC1wcm9kLmFz/c2V0cy9zdmcvMzA1/LzNmMWQ2NzYxLWJl/NmItNGVmNi04MDFi/LWNjYjE5ZDVkNTNk/Mi5zdmc.png","Food delivery"),
        OnBoard("https://img.freepik.com/vecteurs-libre/livraison-deballage-colis-reception-commande-controle-du-contenu-boite-personnage-dessin-anime-destinataire-femelle-service-expedition-cible_335657-2562.jpg?w=2000","Document delivery"),
        OnBoard("https://thumbs.dreamstime.com/b/flower-delivery-modern-vector-cartoon-people-characters-illustration-white-background-high-quality-colorful-composition-141776928.jpg","Flower delivery"),
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