package ru.vdh.todo.app.di

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import ru.vdh.todo.R
import ru.vdh.todo.app.navigation.AppAddToDoDestinationToUiMapper
import ru.vdh.todo.app.navigation.AppToDoListDestinationToUiMapper
import ru.vdh.todo.navigation.mapper.GlobalDestinationToUiMapper
import ru.vdh.todo.app.navigation.AppUpdateToDoDestinationToUiMapper

@Module
@InstallIn(ActivityComponent::class)
class NavigationModule {
    @Provides
    fun providesSupportFragmentManager(activity: Activity) =
        (activity as AppCompatActivity).supportFragmentManager

    @Provides
    fun providesNavHostFragment(fragmentManager: FragmentManager) =
        fragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment

    @Provides
    fun providesNavController(navHostFragment: NavHostFragment) =
        navHostFragment.navController

    @Provides
    fun providesGlobalDestinationToUiMapper(
        lazyNavController: Lazy<NavController>
    ) = GlobalDestinationToUiMapper(lazyNavController)

    @Provides
    fun providesAppToDoListDestinationToUiMapper(
        globalDestinationToUiMapper: GlobalDestinationToUiMapper
    ): ru.vdh.todo.todolist.ui.mapper.NewFeatureDestinationToUiMapper =
        AppToDoListDestinationToUiMapper(globalDestinationToUiMapper)

    @Provides
    fun providesAppAddToDoDestinationToUiMapper(
        globalDestinationToUiMapper: GlobalDestinationToUiMapper
    ): ru.vdh.todo.addtodo.ui.mapper.NewFeatureDestinationToUiMapper =
        AppAddToDoDestinationToUiMapper(globalDestinationToUiMapper)

    @Provides
    fun providesAppUpdateToDoDestinationToUiMapper(
        globalDestinationToUiMapper: GlobalDestinationToUiMapper
    ): ru.vdh.todo.updatetodo.ui.mapper.NewFeatureDestinationToUiMapper =
        AppUpdateToDoDestinationToUiMapper(globalDestinationToUiMapper)
}
