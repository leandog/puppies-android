class PuppyDetails
  include Gametel

  activity "PuppyTaleActivity"

  text(:name, :id => 'name')
  text(:breed, :id => 'breed')
  text(:gender, :id => 'gender')
  text(:description, :id => 'description')
  text(:fee, :id => 'adoption_fee')
  image(:headshot, :id => 'headshot')

end
