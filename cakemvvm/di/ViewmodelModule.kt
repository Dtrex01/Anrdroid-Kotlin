package com.example.cakemvvm.di

import com.example.cakemvvm.viewmodel.CakeListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule= module {
    viewModel { CakeListViewModel(get()) }
}