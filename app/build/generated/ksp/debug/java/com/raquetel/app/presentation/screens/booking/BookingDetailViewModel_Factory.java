package com.raquetel.app.presentation.screens.booking;

import com.raquetel.app.domain.repositories.BookingRepository;
import com.raquetel.app.domain.usecases.booking.CancelBookingUseCase;
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
public final class BookingDetailViewModel_Factory implements Factory<BookingDetailViewModel> {
  private final Provider<BookingRepository> bookingRepositoryProvider;

  private final Provider<CancelBookingUseCase> cancelBookingUseCaseProvider;

  public BookingDetailViewModel_Factory(Provider<BookingRepository> bookingRepositoryProvider,
      Provider<CancelBookingUseCase> cancelBookingUseCaseProvider) {
    this.bookingRepositoryProvider = bookingRepositoryProvider;
    this.cancelBookingUseCaseProvider = cancelBookingUseCaseProvider;
  }

  @Override
  public BookingDetailViewModel get() {
    return newInstance(bookingRepositoryProvider.get(), cancelBookingUseCaseProvider.get());
  }

  public static BookingDetailViewModel_Factory create(
      Provider<BookingRepository> bookingRepositoryProvider,
      Provider<CancelBookingUseCase> cancelBookingUseCaseProvider) {
    return new BookingDetailViewModel_Factory(bookingRepositoryProvider, cancelBookingUseCaseProvider);
  }

  public static BookingDetailViewModel newInstance(BookingRepository bookingRepository,
      CancelBookingUseCase cancelBookingUseCase) {
    return new BookingDetailViewModel(bookingRepository, cancelBookingUseCase);
  }
}
