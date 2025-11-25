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
public final class GetBookingsUseCase_Factory implements Factory<GetBookingsUseCase> {
  private final Provider<BookingRepository> repositoryProvider;

  public GetBookingsUseCase_Factory(Provider<BookingRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetBookingsUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetBookingsUseCase_Factory create(Provider<BookingRepository> repositoryProvider) {
    return new GetBookingsUseCase_Factory(repositoryProvider);
  }

  public static GetBookingsUseCase newInstance(BookingRepository repository) {
    return new GetBookingsUseCase(repository);
  }
}
