package com.example.cakemvvm.recycler_adapters



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cakemvvm.R
import com.example.cakemvvm.database.DatabaseCake
import com.example.cakemvvm.databinding.RowCakesBinding
import okhttp3.internal.notify

class CakeAdapter: RecyclerView.Adapter<CakeViewHolder>() {
    private var viewModelAdapter: CakeAdapter? = null
    var results: List<DatabaseCake> = emptyList()
        set(value) {
            field = value
            // countryFilterList = results
            // Notify any registered observers that the data set has changed. This will cause every
            // element in our RecyclerView to be invalidated.

             notifyDataSetChanged()
        }


    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakeViewHolder {
        val withDataBinding: RowCakesBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            CakeViewHolder.LAYOUT,
            parent,
            false
        )
        return CakeViewHolder(withDataBinding)
    }

    override fun getItemCount() = results.size

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    override fun onBindViewHolder(holder: CakeViewHolder, position: Int) {
//        holder.itemView.title.text = countryFilterList[position]
        holder.viewDataBinding.also {
            it.results = results[position]
            //To handle onclick : In Databinding
            // it.resultsCallback = callback

        }
    }
}
/**
 * ViewHolder for cake items. All work is done by data binding.
 */
class CakeViewHolder(val viewDataBinding: RowCakesBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.row_cakes
    }
}

class CakeClick(val block: (DatabaseCake)->Unit){
    fun onClick(cake: DatabaseCake)= block(cake)
}