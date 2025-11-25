package com.raquetel.app.presentation.screens.booking;

import com.raquetel.app.domain.usecases.booking.CreateBookingUseCase;
import com.raquetel.app.domain.usecases.court.GetCourtsUseCase;
import com.raquetel.app.domain.usecases.customer.GetCustomersUseCase;
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
public final class CreateBookingViewModel_Factory implements Factory<CreateBookingViewModel> {
  private final Provider<GetCustomersUseCase> getCustomersUseCaseProvider;

  private final Provider<GetCourtsUseCase> getCourtsUseCaseProvider;

  private final Provider<CreateBookingUseCase> createBookingUseCaseProvider;

  public CreateBookingViewModel_Factory(Provider<GetCustomersUseCase> getCustomersUseCaseProvider,
      Provider<GetCourtsUseCase> getCourtsUseCaseProvider,
      Provider<CreateBookingUseCase> createBookingUseCaseProvider) {
    this.getCustomersUseCaseProvider = getCustomersUseCaseProvider;
    this.getCourtsUseCaseProvider = getCourtsUseCaseProvider;
    this.createBookingUseCaseProvider = createBookingUseCaseProvider;
  }

  @Override
  public CreateBookingViewModel get() {
    return newInstance(getCustomersUseCaseProvider.get(), getCourtsUseCaseProvider.get(), createBookingUseCaseProvider.get());
  }

  public static CreateBookingViewModel_Factory create(
      Provider<GetCustomersUseCase> getCustomersUseCaseProvider,
      Provider<GetCourtsUseCase> getCourtsUseCaseProvider,
      Provider<CreateBookingUseCase> createBookingUseCaseProvider) {
    return new CreateBookingViewModel_Factory(getCustomersUseCaseProvider, getCourtsUseCaseProvider, createBookingUseCaseProvider);
  }

  public static CreateBookingViewModel newInstance(GetCustomersUseCase getCustomersUseCase,
      GetCourtsUseCase getCourtsUseCase, CreateBookingUseCase createBookingUseCase) {
    return new CreateBookingViewModel(getCustomersUseCase, getCourtsUseCase, createBookingUseCase);
  }
}
