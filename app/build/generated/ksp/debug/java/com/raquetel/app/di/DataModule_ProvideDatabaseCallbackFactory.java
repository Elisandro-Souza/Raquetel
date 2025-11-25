package com.raquetel.app.di;

import android.content.Context;
import androidx.room.RoomDatabase;
import com.raquetel.app.data.local.database.RaquetelDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class DataModule_ProvideDatabaseCallbackFactory implements Factory<RoomDatabase.Callback> {
  private final Provider<Context> contextProvider;

  private final Provider<RaquetelDatabase> databaseProvider;

  public DataModule_ProvideDatabaseCallbackFactory(Provider<Context> contextProvider,
      Provider<RaquetelDatabase> databaseProvider) {
    this.contextProvider = contextProvider;
    this.databaseProvider = databaseProvider;
  }

  @Override
  public RoomDatabase.Callback get() {
    return provideDatabaseCallback(contextProvider.get(), databaseProvider.get());
  }

  public static DataModule_ProvideDatabaseCallbackFactory create(Provider<Context> contextProvider,
      Provider<RaquetelDatabase> databaseProvider) {
    return new DataModule_ProvideDatabaseCallbackFactory(contextProvider, databaseProvider);
  }

  public static RoomDatabase.Callback provideDatabaseCallback(Context context,
      RaquetelDatabase database) {
    return Preconditions.checkNotNullFromProvides(DataModule.INSTANCE.provideDatabaseCallback(context, database));
  }
}
