package com.raquetel.app.di;

import com.raquetel.app.data.local.dao.CourtDao;
import com.raquetel.app.data.local.database.RaquetelDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
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
public final class DatabaseModule_ProvideCourtDaoFactory implements Factory<CourtDao> {
  private final Provider<RaquetelDatabase> databaseProvider;

  public DatabaseModule_ProvideCourtDaoFactory(Provider<RaquetelDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public CourtDao get() {
    return provideCourtDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideCourtDaoFactory create(
      Provider<RaquetelDatabase> databaseProvider) {
    return new DatabaseModule_ProvideCourtDaoFactory(databaseProvider);
  }

  public static CourtDao provideCourtDao(RaquetelDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideCourtDao(database));
  }
}
