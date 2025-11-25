package com.raquetel.app.di;

import com.raquetel.app.data.local.dao.CustomerDao;
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
public final class DatabaseModule_ProvideCustomerDaoFactory implements Factory<CustomerDao> {
  private final Provider<RaquetelDatabase> databaseProvider;

  public DatabaseModule_ProvideCustomerDaoFactory(Provider<RaquetelDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public CustomerDao get() {
    return provideCustomerDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideCustomerDaoFactory create(
      Provider<RaquetelDatabase> databaseProvider) {
    return new DatabaseModule_ProvideCustomerDaoFactory(databaseProvider);
  }

  public static CustomerDao provideCustomerDao(RaquetelDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideCustomerDao(database));
  }
}
