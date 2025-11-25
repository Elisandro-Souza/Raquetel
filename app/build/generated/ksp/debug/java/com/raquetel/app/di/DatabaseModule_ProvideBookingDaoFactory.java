package com.raquetel.app.di;

import com.raquetel.app.data.local.dao.BookingDao;
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
public final class DatabaseModule_ProvideBookingDaoFactory implements Factory<BookingDao> {
  private final Provider<RaquetelDatabase> databaseProvider;

  public DatabaseModule_ProvideBookingDaoFactory(Provider<RaquetelDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public BookingDao get() {
    return provideBookingDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideBookingDaoFactory create(
      Provider<RaquetelDatabase> databaseProvider) {
    return new DatabaseModule_ProvideBookingDaoFactory(databaseProvider);
  }

  public static BookingDao provideBookingDao(RaquetelDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideBookingDao(database));
  }
}
