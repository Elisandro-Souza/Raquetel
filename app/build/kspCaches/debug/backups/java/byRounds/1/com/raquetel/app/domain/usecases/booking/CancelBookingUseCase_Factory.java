package com.raquetel.app.domain.usecases.booking;

import com.raquetel.app.domain.repositories.BookingRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class CancelBookingUseCase_Factory implements Factory<CancelBookingUseCase> {
  private final Provider<BookingRepository> repositoryProvider;

  public CancelBookingUseCase_Factory(Provider<BookingRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public CancelBookingUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static CancelBookingUseCase_Factory create(
      Provider<BookingRepository> repositoryProvider) {
    return new CancelBookingUseCase_Factory(repositoryProvider);
  }

  public static CancelBookingUseCase newInstance(BookingRepository repository) {
    return new CancelBookingUseCase(repository);
  }
}
