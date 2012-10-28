class PuppyDetails
  include Gametel

  text(:name, :id => 'name')
  text(:breed, :id => 'breed')
  text(:gender, :id => 'gender')
  text(:description, :id => 'description')
  text(:fee, :id => 'adoption_fee')

  def active?
    platform.wait_for_activity "PuppyTaleActivity"
    platform.last_json
  end

  def has_image?
    platform.get_view_by_id 'headshot'
    platform.last_json['hasDrawable']
  end

end
