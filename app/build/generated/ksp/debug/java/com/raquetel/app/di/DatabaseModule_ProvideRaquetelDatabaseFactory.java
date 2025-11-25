package com.raquetel.app.di;

import android.content.Context;
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
public final class DatabaseModule_ProvideRaquetelDatabaseFactory implements Factory<RaquetelDatabase> {
  private final Provider<Context> contextProvider;

  public DatabaseModule_ProvideRaquetelDatabaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public RaquetelDatabase get() {
    return provideRaquetelDatabase(contextProvider.get());
  }

  public static DatabaseModule_ProvideRaquetelDatabaseFactory create(
      Provider<Context> contextProvider) {
    return new DatabaseModule_ProvideRaquetelDatabaseFactory(contextProvider);
  }

  public static RaquetelDatabase provideRaquetelDatabase(Context context) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideRaquetelDatabase(context));
  }
}
