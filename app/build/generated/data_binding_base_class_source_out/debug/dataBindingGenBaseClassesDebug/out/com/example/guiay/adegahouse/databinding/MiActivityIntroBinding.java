package com.example.guiay.adegahouse.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextSwitcher;
import com.heinrichreimersoftware.materialintro.view.FadeableViewPager;
import com.heinrichreimersoftware.materialintro.view.InkPageIndicator;

public abstract class MiActivityIntroBinding extends ViewDataBinding {
  @NonNull
  public final ImageButton miButtonBack;

  @NonNull
  public final TextSwitcher miButtonCta;

  @NonNull
  public final ImageButton miButtonNext;

  @NonNull
  public final ConstraintLayout miFrame;

  @NonNull
  public final FadeableViewPager miPager;

  @NonNull
  public final InkPageIndicator miPagerIndicator;

  protected MiActivityIntroBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageButton miButtonBack, TextSwitcher miButtonCta,
      ImageButton miButtonNext, ConstraintLayout miFrame, FadeableViewPager miPager,
      InkPageIndicator miPagerIndicator) {
    super(_bindingComponent, _root, _localFieldCount);
    this.miButtonBack = miButtonBack;
    this.miButtonCta = miButtonCta;
    this.miButtonNext = miButtonNext;
    this.miFrame = miFrame;
    this.miPager = miPager;
    this.miPagerIndicator = miPagerIndicator;
  }

  @NonNull
  public static MiActivityIntroBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static MiActivityIntroBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<MiActivityIntroBinding>inflate(inflater, com.example.guiay.adegahouse.R.layout.mi_activity_intro, root, attachToRoot, component);
  }

  @NonNull
  public static MiActivityIntroBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static MiActivityIntroBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<MiActivityIntroBinding>inflate(inflater, com.example.guiay.adegahouse.R.layout.mi_activity_intro, null, false, component);
  }

  public static MiActivityIntroBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static MiActivityIntroBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (MiActivityIntroBinding)bind(component, view, com.example.guiay.adegahouse.R.layout.mi_activity_intro);
  }
}
