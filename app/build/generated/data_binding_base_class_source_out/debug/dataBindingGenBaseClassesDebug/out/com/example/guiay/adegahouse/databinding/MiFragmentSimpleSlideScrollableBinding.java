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

public abstract class MiFragmentSimpleSlideScrollableBinding extends ViewDataBinding {
  @NonNull
  public final TextView miDescription;

  @NonNull
  public final ImageView miImage;

  @NonNull
  public final TextView miTitle;

  protected MiFragmentSimpleSlideScrollableBinding(DataBindingComponent _bindingComponent,
      View _root, int _localFieldCount, TextView miDescription, ImageView miImage,
      TextView miTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.miDescription = miDescription;
    this.miImage = miImage;
    this.miTitle = miTitle;
  }

  @NonNull
  public static MiFragmentSimpleSlideScrollableBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static MiFragmentSimpleSlideScrollableBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<MiFragmentSimpleSlideScrollableBinding>inflate(inflater, com.example.guiay.adegahouse.R.layout.mi_fragment_simple_slide_scrollable, root, attachToRoot, component);
  }

  @NonNull
  public static MiFragmentSimpleSlideScrollableBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static MiFragmentSimpleSlideScrollableBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<MiFragmentSimpleSlideScrollableBinding>inflate(inflater, com.example.guiay.adegahouse.R.layout.mi_fragment_simple_slide_scrollable, null, false, component);
  }

  public static MiFragmentSimpleSlideScrollableBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static MiFragmentSimpleSlideScrollableBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (MiFragmentSimpleSlideScrollableBinding)bind(component, view, com.example.guiay.adegahouse.R.layout.mi_fragment_simple_slide_scrollable);
  }
}
