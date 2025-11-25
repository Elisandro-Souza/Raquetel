package com.raquetel.app.presentation.screens.booking;

import com.raquetel.app.domain.usecases.booking.GetBookingsUseCase;
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
public final class BookingListViewModel_Factory implements Factory<BookingListViewModel> {
  private final Provider<GetBookingsUseCase> getBookingsUseCaseProvider;

  public BookingListViewModel_Factory(Provider<GetBookingsUseCase> getBookingsUseCaseProvider) {
    this.getBookingsUseCaseProvider = getBookingsUseCaseProvider;
  }

  @Override
  public BookingListViewModel get() {
    return newInstance(getBookingsUseCaseProvider.get());
  }

  public static BookingListViewModel_Factory create(
      Provider<GetBookingsUseCase> getBookingsUseCaseProvider) {
    return new BookingListViewModel_Factory(getBookingsUseCaseProvider);
  }

  public static BookingListViewModel newInstance(GetBookingsUseCase getBookingsUseCase) {
    return new BookingListViewModel(getBookingsUseCase);
  }
}
