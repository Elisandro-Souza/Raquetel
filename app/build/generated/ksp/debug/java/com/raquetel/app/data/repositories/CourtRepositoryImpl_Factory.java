package com.raquetel.app.data.repositories;

import com.raquetel.app.data.local.dao.CourtDao;
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
public final class CourtRepositoryImpl_Factory implements Factory<CourtRepositoryImpl> {
  private final Provider<CourtDao> courtDaoProvider;

  public CourtRepositoryImpl_Factory(Provider<CourtDao> courtDaoProvider) {
    this.courtDaoProvider = courtDaoProvider;
  }

  @Override
  public CourtRepositoryImpl get() {
    return newInstance(courtDaoProvider.get());
  }

  public static CourtRepositoryImpl_Factory create(Provider<CourtDao> courtDaoProvider) {
    return new CourtRepositoryImpl_Factory(courtDaoProvider);
  }

  public static CourtRepositoryImpl newInstance(CourtDao courtDao) {
    return new CourtRepositoryImpl(courtDao);
  }
}
