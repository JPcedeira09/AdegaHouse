package com.example.guiay.adegahouse.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class MiFragmentSimpleSlideBinding extends ViewDataBinding {
  @NonNull
  public final TextView miDescription;

  @NonNull
  public final ImageView miImage;

  @NonNull
  public final TextView miTitle;

  protected MiFragmentSimpleSlideBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView miDescription, ImageView miImage, TextView miTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.miDescription = miDescription;
    this.miImage = miImage;
    this.miTitle = miTitle;
  }

  @NonNull
  public static MiFragmentSimpleSlideBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static MiFragmentSimpleSlideBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<MiFragmentSimpleSlideBinding>inflate(inflater, com.example.guiay.adegahouse.R.layout.mi_fragment_simple_slide, root, attachToRoot, component);
  }

  @NonNull
  public static MiFragmentSimpleSlideBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static MiFragmentSimpleSlideBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<MiFragmentSimpleSlideBinding>inflate(inflater, com.example.guiay.adegahouse.R.layout.mi_fragment_simple_slide, null, false, component);
  }

  public static MiFragmentSimpleSlideBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static MiFragmentSimpleSlideBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (MiFragmentSimpleSlideBinding)bind(component, view, com.example.guiay.adegahouse.R.layout.mi_fragment_simple_slide);
  }
}
