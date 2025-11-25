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
public final class CreateBookingUseCase_Factory implements Factory<CreateBookingUseCase> {
  private final Provider<BookingRepository> repositoryProvider;

  public CreateBookingUseCase_Factory(Provider<BookingRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public CreateBookingUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static CreateBookingUseCase_Factory create(
      Provider<BookingRepository> repositoryProvider) {
    return new CreateBookingUseCase_Factory(repositoryProvider);
  }

  public static CreateBookingUseCase newInstance(BookingRepository repository) {
    return new CreateBookingUseCase(repository);
  }
}
