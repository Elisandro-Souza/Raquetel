package com.raquetel.app.data.repositories;

import com.raquetel.app.data.local.dao.BookingDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class BookingRepositoryImpl_Factory implements Factory<BookingRepositoryImpl> {
  private final Provider<BookingDao> bookingDaoProvider;

  public BookingRepositoryImpl_Factory(Provider<BookingDao> bookingDaoProvider) {
    this.bookingDaoProvider = bookingDaoProvider;
  }

  @Override
  public BookingRepositoryImpl get() {
    return newInstance(bookingDaoProvider.get());
  }

  public static BookingRepositoryImpl_Factory create(Provider<BookingDao> bookingDaoProvider) {
    return new BookingRepositoryImpl_Factory(bookingDaoProvider);
  }

  public static BookingRepositoryImpl newInstance(BookingDao bookingDao) {
    return new BookingRepositoryImpl(bookingDao);
  }
}
