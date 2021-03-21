package com.abdulmughni.personal.screentoday.di

import com.abdulmughni.personal.screentoday.core.domain.usecase.MovieInteractor
import com.abdulmughni.personal.screentoday.core.domain.usecase.MovieUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@Module
@InstallIn(ActivityComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideMovieUseCase(movieInteractor: MovieInteractor): MovieUseCase

}